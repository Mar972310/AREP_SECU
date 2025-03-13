async function login(event) {
    event.preventDefault();  

    const formData = new FormData(document.querySelector("#loginForm")); 
    const userData = {
        mail: formData.get("mail"),
        password: formData.get("password"),
    };

    try {
        const response = await fetch("/users/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(userData),
        });

        // Check if the response is successful
        if (!response.ok) {
            const responseText = await response.text();
            alert("Login failed: " + responseText || "Please try again.");
            const messageContainer = document.querySelector('.message');
            if (messageContainer) {
                messageContainer.innerHTML = `<h3>${responseText}</h3>`;
                throw new Error(`Error saving property: ${response.statusText}`);
            }
            return; 
        }

        const jsonResponse = await response.json();
        window.location.href = "/properties";  

    } catch (error) {
        alert("There was an error during the login process. Please try again.");
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("#loginForm");
    form.addEventListener("submit", login);
});
