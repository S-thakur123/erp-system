terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0.1"
    }
  }
}

provider "docker" {}

# 1. Create a dedicated network for ERP Modules
resource "docker_network" "erp_network" {
  name = "erp_enterprise_network"
}

# 2. Production PostgreSQL Database
resource "docker_container" "postgres_db" {
  name  = "erp-db-prod"
  image = "postgres:14-alpine"
  networks_advanced {
    name = docker_network.erp_network.name
  }
  env = [
    "POSTGRES_USER=admin",
    "POSTGRES_PASSWORD=password",
    "POSTGRES_DB=erp_db"
  ]
  ports {
    internal = 5432
    external = 5432
  }
}

# 3. ERP API Container (Modular Monolith)
resource "docker_container" "erp_api" {
  name  = "erp-api-prod"
  image = "erp-system-api:latest"
  networks_advanced {
    name = docker_network.erp_network.name
  }
  ports {
    internal = 8080
    external = 8080
  }
  env = [
    "SPRING_DATASOURCE_URL=jdbc:postgresql://erp-db-prod:5432/erp_db",
    "SPRING_PROFILES_ACTIVE=prod"
  ]
  depends_on = [docker_container.postgres_db]
}