/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



let lawyerButtonElt = document.getElementById("lawyerButtonElt");
let judgeButtonElt = document.getElementById("judgeButtonElt");
let loginHeadingEl = document.getElementById("headingEL");
let nameEl= document.getElementById("name");
let usernameEl = document.getElementById("username");

let registerPasswordEl = document.getElementById("registerpassword");
let deleteAcoountBtnEl = document.getElementById("deleteAcoountBtn");
let formEl = document.getElementById("deleteForm");
let labelNameEl = document.getElementById("labelName");
let hidden_name = document.getElementById("hidden_name");

let accountdeleteFor = "lawyer";
lawyerButtonElt.onclick = function(){
    lawyerButtonElt.classList.remove("btn-light");
    lawyerButtonElt.classList.add("btn-primary");
    judgeButtonElt.classList.add("btn-light");
    judgeButtonElt.classList.remove("btn-primary");
    loginHeadingEl.textContent = "Lawyer Account";
    accountdeleteFor = "lawyer";
    labelNameEl.textContent = "Lawer Name";
    hidden_name.value = "lawyer";
}

judgeButtonElt.onclick = function(){
    lawyerButtonElt.classList.add("btn-light");
    lawyerButtonElt.classList.remove("btn-primary");
    judgeButtonElt.classList.remove("btn-light");
    judgeButtonElt.classList.add("btn-primary");
    loginHeadingEl.textContent = "Judge Account";
    accountdeleteFor = "judge";
    labelNameEl.textContent = "Judge Name";
    hidden_name.value = "judge";
}
