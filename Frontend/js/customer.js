const API = "http://localhost:8080/api/customers";

// Load all customers
async function loadCustomers() {

    try {

        const response = await fetch(API);
        const customers = await response.json();

        const table = document.getElementById("customerTable");
        table.innerHTML = "";

        customers.forEach(customer => {

            table.innerHTML += `
                <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.towerName}</td>
                    <td>${customer.contactPerson}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.address}</td>
                </tr>
            `;

        });

    } catch (error) {

        console.log("Error loading customers:", error);

    }

}

// Save customer
async function saveCustomer() {

    const customer = {

        towerName: document.getElementById("towerName").value,
        contactPerson: document.getElementById("contactPerson").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phone").value,
        address: document.getElementById("address").value

    };

    // Simple validation
    if (
        customer.towerName === "" ||
        customer.contactPerson === "" ||
        customer.email === "" ||
        customer.phone === "" ||
        customer.address === ""
    ) {
        alert("Please fill all fields");
        return;
    }

    try {

        const response = await fetch(API, {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(customer)

        });

        if (response.ok) {

            alert("Customer Added Successfully!");

            document.getElementById("towerName").value = "";
            document.getElementById("contactPerson").value = "";
            document.getElementById("email").value = "";
            document.getElementById("phone").value = "";
            document.getElementById("address").value = "";

            loadCustomers();

        } else {

            alert("Failed to save customer");

        }

    } catch (error) {

        console.log("Error:", error);
        alert("Server not running");

    }

}

// Load data when page opens
loadCustomers();