
const username = "vasanth";
const password = "admin1234";
const credentials = btoa(`${username}:${password}`);



function  showCourses(){
    fetch("http://localhost:8080/courses",{
        method: "GET",
        mode: "cors", // Ensure CORS mode is enabled
        headers: {
            "Authorization": `Basic ${credentials}`, // Send credentials in the header
            "Content-Type": "application/json"
        }
    })
    .then((response)=>response.json())
    .then((courses)=> {
         const datatable = document.getElementById("coursetable")
         
        courses.forEach(course => {
            var row = `<tr>
                <td>${course.id}</td>
                <td>${course.courseName}</td>
                <td>${course.trainer}</td>
                <td>${course.durationTime}</td>
            </tr>`
          
            datatable.innerHTML+=row;
        });
    })
}

function enrolledCourses(){
    fetch("http://localhost:8080/admin/courses-enrolled",{
        method: "GET",
        mode: "cors", // Ensure CORS mode is enabled
        headers: {
            "Authorization": `Basic ${credentials}`, // Send credentials in the header
            "Content-Type": "application/json"
        }
    })
    .then((response) => response.json())
    .then((students) => {
          const datatable = document.getElementById("enrolledtable")
        students.forEach(student =>{
            var row = `<tr id="row-${student.id}">
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.emailId}</td>
                <td>${student.courseName}</td>
                <td><button onclick=deleteCourse(${student.id})>Delete</button></td>
            </tr>`

            datatable.innerHTML+=row;
        })
       
    })
}

function deleteCourse(id){
    fetch(`http://localhost:8080/admin/courses/${id}`,{
        method: "DELETE",
        mode: "cors", // Ensure CORS mode is enabled
        headers: {
            "Authorization": `Basic ${credentials}`, // Send credentials in the header
            "Content-Type": "application/json"
        }
    })
    .then((response)=>{
        if(response.ok){
            console.log("delete successful")
            const row = document.getElementById(`row-${id}`);
            if (row) {
                row.remove();
            }
        }else{
            console.error(`Failed to delete course with ID ${id}.`);
        }
        return response.text();
    })
    .catch((error)=>{
        console.log(error);
    })
}