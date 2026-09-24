const API = "http://localhost:8080/api/plants";

// Load all plants
async function loadPlants() {
    try {
        const response = await fetch(API);
        const plants = await response.json();

        const table = document.getElementById("plantTable");
        table.innerHTML = "";

        plants.forEach(plant => {
            table.innerHTML += `
                <tr>
                    <td>${plant.plantId}</td>
                    <td>${plant.plantName}</td>
                    <td>${plant.location}</td>
                    <td>${plant.iceStorageCapacity}</td>
                    <td>${plant.status}</td>
                </tr>
            `;
        });

    } catch (error) {
        console.log("Error loading plants:", error);
    }
}

// Save plant
async function savePlant() {

    const plant = {
        plantName: document.getElementById("plantName").value,
        location: document.getElementById("location").value,
        iceStorageCapacity: parseFloat(document.getElementById("iceStorageCapacity").value),
        status: document.getElementById("status").value
    };

    if (
        plant.plantName === "" ||
        plant.location === "" ||
        isNaN(plant.iceStorageCapacity) ||
        plant.status === ""
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
            body: JSON.stringify(plant)
        });

        if (response.ok) {
            alert("Plant Added Successfully!");

            document.getElementById("plantName").value = "";
            document.getElementById("location").value = "";
            document.getElementById("iceStorageCapacity").value = "";
            document.getElementById("status").value = "";

            loadPlants();
        } else {
            alert("Failed to save plant");
        }

    } catch (error) {
        console.log(error);
        alert("Server not running");
    }
}

loadPlants();