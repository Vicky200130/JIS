/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */





let lawyerButtonElt = document.getElementById("lawyerButtonElt");
let judgeButtonElt = document.getElementById("judgeButtonElt");
let loginHeadingEl = document.getElementById("headingEL");
let nameEl= document.getElementById("name");
let usernameEl = document.getElementById("username");
let passwordEl = document.getElementById("password")
let registerPasswordEl = document.getElementById("registerpassword");
let createAcoountBtnEl = document.getElementById("createAcoountBtn");
let formEl = document.getElementById("createForm");
let labelNameEl = document.getElementById("labelName");
let hidden_name = document.getElementById("hidden_name");

let accountCreateFor = "lawyer";
lawyerButtonElt.onclick = function(){
    lawyerButtonElt.classList.remove("btn-light");
    lawyerButtonElt.classList.add("btn-primary");
    judgeButtonElt.classList.add("btn-light");
    judgeButtonElt.classList.remove("btn-primary");
    loginHeadingEl.textContent = "Lawyer Account";
    accountCreateFor = "lawyer";
    labelNameEl.textContent = "Lawer Name"
    hidden_name.value = "lawyer";
}

judgeButtonElt.onclick = function(){
    lawyerButtonElt.classList.add("btn-light");
    lawyerButtonElt.classList.remove("btn-primary");
    judgeButtonElt.classList.remove("btn-light");
    judgeButtonElt.classList.add("btn-primary");
    loginHeadingEl.textContent = "Judge Acoount";
    accountCreateFor = "judge";
    labelNameEl.textContent = "Judge Name";
    hidden_name.value = "judge";
}

//formEl.addEventListener("submit" ,function(event){
//    event.preventDefault();
//    let name = nameEl.value ;
//    let username = usernameEl.value ;
//    let password = passwordEl.value;
//
//    let profile ={
//        "name" : name ,
//        "username" : username,
//        "password" : password 
//    };
//    let jsonString12  = JSON.stringify(profile);
//    console.log(jsonString12);
//    
//    localStorage.setItem("key", jsonString12);
//    console.log(accountCreateFor);
//    console.log(name , username , password);
//    nameEl.value = "";
//    usernameEl.value="";
//    passwordEl.value = "";
//    registerPasswordEl.value = "";
//
//});
//localStorage.setItem("fullName", "Rahul Attuluri");
//
//localStorage.setItem("gender", "Male");
//
//localStorage.setItem("city", "Delhi");
//
//let fullName = localStorage.getItem("fullName");
//
//let gender = localStorage.getItem("gender");
//
//let city = localStorage.getItem("city");
//
//console.log(fullName);
//console.log(gender);
//console.log(city);