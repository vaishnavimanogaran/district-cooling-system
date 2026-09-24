const CUSTOMER_API = "http://localhost:8080/api/customers";
const INVOICE_API = "http://localhost:8080/api/invoices";

// Load customers into dropdown
async function loadCustomers() {
    const res = await fetch(CUSTOMER_API);
    const customers = await res.json();

    const select = document.getElementById("customer");
    select.innerHTML = '<option value="">Select Customer</option>';

    customers.forEach(c => {
        select.innerHTML += `
            <option value="${c.customerId}">
                ${c.towerName}
            </option>`;
    });
}

// Load all invoices
async function loadInvoices() {
    const res = await fetch(INVOICE_API);
    const invoices = await res.json();

    const table = document.getElementById("invoiceTable");
    table.innerHTML = "";

    invoices.forEach(i => {
        table.innerHTML += `
        <tr>
            <td>${i.invoiceId}</td>
            <td>${i.customer.towerName}</td>
            <td>${i.invoiceDate}</td>
            <td>${i.tonHours}</td>
            <td>₹${i.ratePerTon}</td>
            <td>₹${i.totalAmount}</td>
        </tr>`;
    });
}

// Generate invoice
async function saveInvoice() {

    const customerId = document.getElementById("customer").value;

    if (customerId === "") {
        alert("Please select a customer");
        return;
    }

    const res = await fetch(
        `${INVOICE_API}/generate/${customerId}`,
        { method: "POST" }
    );

    if (res.ok) {
        alert("Invoice Generated Successfully");
        loadInvoices();
    } else {
        alert("Failed to generate invoice");
    }
}

loadCustomers();
loadInvoices();