const BASE = "http://localhost:8080/api";

async function loadDashboard() {

    try {

        const customers = await fetch(BASE + "/customers").then(r => r.json());
        const plants = await fetch(BASE + "/plants").then(r => r.json());
        const vendors = await fetch(BASE + "/vendors").then(r => r.json());
        const invoices = await fetch(BASE + "/invoices").then(r => r.json());

        document.getElementById("customerCount").innerText = customers.length;
        document.getElementById("plantCount").innerText = plants.length;
        document.getElementById("vendorCount").innerText = vendors.length;
        document.getElementById("invoiceCount").innerText = invoices.length;

    } catch (e) {
        console.log("Backend not running");
    }

}

loadDashboard();