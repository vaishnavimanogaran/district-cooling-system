const API = "http://localhost:8080/api/reports/dashboard";

async function loadReport() {

    try {

        const response = await fetch(API);
        const data = await response.json();

        document.getElementById("customers").innerText = data.totalCustomers;
        document.getElementById("plants").innerText = data.totalPlants;
        document.getElementById("vendors").innerText = data.totalVendors;

        document.getElementById("revenue").innerText =
            "₹" + data.totalRevenue;

        document.getElementById("expense").innerText =
            "₹" + data.totalExpense;

        document.getElementById("profit").innerText =
            "₹" + data.netProfit;

    } catch (error) {

        console.log(error);
        alert("Unable to load report");

    }

}

loadReport();