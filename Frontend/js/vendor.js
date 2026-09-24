const API = "http://localhost:8080/api/vendors";

// Load vendors
async function loadVendors() {
    try {
        const response = await fetch(API);
        const vendors = await response.json();

        const table = document.getElementById("vendorTable");
        table.innerHTML = "";

        vendors.forEach(vendor => {
            table.innerHTML += `
                <tr>
                    <td>${vendor.vendorId}</td>
                    <td>${vendor.companyName}</td>
                    <td>${vendor.contactPerson}</td>
                    <td>${vendor.email}</td>
                    <td>${vendor.phone}</td>
                    <td>${vendor.materialSupplied}</td>
                </tr>
            `;
        });

    } catch (error) {
        console.log("Error loading vendors:", error);
    }
}

// Save vendor
async function saveVendor() {

    const vendor = {
        companyName: document.getElementById("companyName").value,
        contactPerson: document.getElementById("contactPerson").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phone").value,
        materialSupplied: document.getElementById("materialSupplied").value
    };

    if (
        vendor.companyName === "" ||
        vendor.contactPerson === "" ||
        vendor.email === "" ||
        vendor.phone === "" ||
        vendor.materialSupplied === ""
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
            body: JSON.stringify(vendor)
        });

        if (response.ok) {
            alert("Vendor Added Successfully!");

            document.getElementById("companyName").value = "";
            document.getElementById("contactPerson").value = "";
            document.getElementById("email").value = "";
            document.getElementById("phone").value = "";
            document.getElementById("materialSupplied").value = "";

            loadVendors();

        } else {
            alert("Failed to save vendor");
        }

    } catch (error) {
        console.log(error);
        alert("Server not running");
    }
}

loadVendors();