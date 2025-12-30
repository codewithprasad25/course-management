const api = "http://localhost:8080";
const regName = document.getElementById("regName");
const regEmail = document.getElementById("regEmail");
const regPassword = document.getElementById("regPassword");
const btn = document.getElementById("register");
const loginBtn = document.getElementById("login");

let studentID = localStorage.getItem("studentId");
console.log(studentID);

loginBtn.addEventListener("click",async ()=>{
    const response = await fetch(`${api}/students/login`,{
        method: "POST",
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify({
            email: loginEmail.value,
            password: loginPassword.value
        })
    })

    const data = await response.json();
    localStorage.setItem("studentId",data.email);
    console.log(data);
    showCourses();
})

btn.addEventListener('click',async ()=>{
    const response = await fetch(`${api}/students/register`,{
        method: "POST",
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify({
            name: regName.value,
            email: regEmail.value,
            password: regPassword.value
        })
    })

    const data = await response.json();
    console.log(data);
});

async function loadCourses() {
    const response = await fetch(`${api}/course/all`,{
        method: "GET",
        headers: {
            "Content-Type" : "application/json"
        }
    })

    const data = await response.json();
    console.log(data);

    data.forEach(element => {
        const row = document.createElement("tr");
        const table = document.getElementById("courseTable");

        row.innerHTML += `
        <td>${element.name}</td>
        <td>${element.instructor}</td>
        <td>${element.duration}</td>
        <td>${element.status}</td>
        <td>
        <button onclick="enrollment(${element.id})">Enroll</button>
        </td>
        `
        table.appendChild(row);
    });
}

async function enrollment(courseId) {
    const response = await fetch(`${api}/enrollment/create`,{
        method: "POST",
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify({
            studentEmail: studentID,
            courseId: courseId
        })
    })

    const data = await response.json();
    console.log(data);


}

if(studentID){
    showCourses();
}



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