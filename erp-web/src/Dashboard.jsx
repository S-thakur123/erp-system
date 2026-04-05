import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer, CartesianGrid } from 'recharts';
import { Package, DollarSign, Users, Activity } from 'lucide-react';

const Dashboard = () => {
    const [stats, setStats] = useState({ totalProducts: 0, totalTransactions: 0, totalCustomers: 0 });

    useEffect(() => {
        // Use the Basic Auth credentials from your Spring Boot logs
        const auth = btoa('user:YOUR_GENERATED_PASSWORD');
        axios.get('http://localhost:8080/api/reports/dashboard', {
            headers: { 'Authorization': `Basic ${auth}` }
        })
        .then(res => setStats(res.data))
        .catch(err => console.error("API Error:", err));
    }, []);

    const chartData = [
        { name: 'Products', count: stats.totalProducts },
        { name: 'Transactions', count: stats.totalTransactions },
        { name: 'Customers', count: stats.totalCustomers },
    ];

    return (
        <div className="p-8 bg-gray-50 min-h-screen">
            <h1 className="text-3xl font-bold mb-8 text-gray-800">ERP Executive Dashboard</h1>

            {/* Stats Grid */}
            <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mb-8">
                <StatCard icon={<Package/>} label="Inventory" value={stats.totalProducts} color="bg-blue-500" />
                <StatCard icon={<DollarSign/>} label="Finance" value={stats.totalTransactions} color="bg-green-500" />
                <StatCard icon={<Users/>} label="Sales" value={stats.totalCustomers} color="bg-purple-500" />
            </div>

            {/* Chart Section */}
            <div className="bg-white p-6 rounded-xl shadow-md">
                <h2 className="text-xl font-semibold mb-4">Module Distribution</h2>
                <div className="h-64">
                    <ResponsiveContainer width="100%" height="100%">
                        <BarChart data={chartData}>
                            <CartesianGrid strokeDasharray="3 3" />
                            <XAxis dataKey="name" />
                            <YAxis />
                            <Tooltip />
                            <Bar dataKey="count" fill="#4F46E5" radius={[4, 4, 0, 0]} />
                        </BarChart>
                    </ResponsiveContainer>
                </div>
            </div>
        </div>
    );
};

const StatCard = ({ icon, label, value, color }) => (
    <div className="bg-white p-6 rounded-xl shadow-md flex items-center space-x-4">
        <div className={`${color} p-3 rounded-lg text-white`}>{icon}</div>
        <div>
            <p className="text-sm text-gray-500">{label}</p>
            <p className="text-2xl font-bold">{value}</p>
        </div>
    </div>
);

export default Dashboard;