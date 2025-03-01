document.getElementById("registrationForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let password = document.getElementById("password").value;
    let phone = document.getElementById("phone").value;
    let email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    
    let nameRegex = /^[A-Za-z]{4,}$/;
    let phoneRegex = /^[0-9]{10}$/;
    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    if (!nameRegex.test(firstName)) {
        alert("First name must contain only alphabets and be more than 4 characters.");
        return;
    }
    if (password.length < 6) {
        alert("Password must be at least 6 characters long.");
        return;
    }
    if (!phoneRegex.test(phone)) {
        alert("Phone number must be exactly 10 digits.");
        return;
    }
    if (!emailRegex.test(email)) {
        alert("Please enter a valid email address.");
        return;
    }
    
    alert("Registration Successful!");
});