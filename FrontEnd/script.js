// ================= BASE CONFIG =================
const api = "http://localhost:8080";

// ================= REGISTER =================
const regName = document.getElementById("regName");
const regEmail = document.getElementById("regEmail");
const regPassword = document.getElementById("regPassword");
const registerBtn = document.getElementById("register");

// ================= LOGIN =================
const loginBtn = document.getElementById("login");
const loginEmail = document.getElementById("loginEmail");
const loginPassword = document.getElementById("loginPassword");

// ================= UI =================
const authSection = document.getElementById("authSection");
const courseSection = document.getElementById("courseSection");
const registerForm = document.getElementById("registerForm");
const loginForm = document.getElementById("loginForm");
const logoutBtn = document.getElementById("logoutBtn");

// ================= SEARCH =================
const searchInput = document.getElementById("searchInput");

// ================= STORAGE =================
let studentEmail = localStorage.getItem("studentEmail");

// ================= LOGIN =================
loginBtn.addEventListener("click", async () => {
    const response = await fetch(`${api}/students/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            email: loginEmail.value,
            password: loginPassword.value
        })
    });

    if (!response.ok) {
        alert("Invalid credentials");
        return;
    }

    const data = await response.json();
    localStorage.setItem("studentEmail", data.email);
    studentEmail = data.email;

    showCourses();
});

// ================= REGISTER =================
registerBtn.addEventListener("click", async () => {
    const response = await fetch(`${api}/students/register`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            name: regName.value,
            email: regEmail.value,
            password: regPassword.value
        })
    });

    const data = await response.json();
    alert("Registration successful");
    console.log(data);
});

// ================= LOAD COURSES =================
async function loadCourses() {
    const response = await fetch(`${api}/course/all`);
    const courses = await response.json();

    const table = document.getElementById("courseTable");
    table.innerHTML = "";

    courses.forEach(course => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${course.name}</td>
            <td>${course.instructor}</td>
            <td>${course.duration}</td>
            <td>${course.status}</td>
            <td><button onclick="enrollment(${course.id})">Enroll</button></td>
        `;
        table.appendChild(row);
    });
}

// ================= SEARCH LOGIC =================
function searchCourse() {
    const filter = searchInput.value.toLowerCase();
    const rows = document.getElementById("courseTable").getElementsByTagName("tr");

    for (let row of rows) {
        const courseName = row.cells[0].innerText.toLowerCase();
        row.style.display = courseName.includes(filter) ? "" : "none";
    }
}

// ================= ENROLL =================
async function enrollment(courseId) {
    const response = await fetch(`${api}/enrollment/create`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            studentEmail: studentId,
            courseId: courseId
        })
    });

    const data = await response.json();
    alert("Enrolled successfully");
    console.log(data);
}

// ================= UI CONTROL =================
function showCourses() {
    authSection.style.display = "none";
    courseSection.style.display = "block";
    logoutBtn.style.display = "inline";
    loadCourses();
}

function showRegister() {
    registerForm.style.display = "block";
    loginForm.style.display = "none";
}

function showLogin() {
    loginForm.style.display = "block";
    registerForm.style.display = "none";
}

function logout() {
    localStorage.removeItem("studentEmail");
    location.reload();
}

// ================= AUTO LOGIN =================
if (studentEmail) {
    showCourses();
}
