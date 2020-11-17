/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
  // var err = [[${error}]]

  // if(err) {
    
  //   Swal.fire({
  //     // position: 'top-end',
  //     icon: 'error',
  //     title: 'Not match',
  //     // showConfirmButton: false,
  //     // timer: 1500
  //   }).then(window.location.href="/");
    
  // }

  // if(document.getElementById('run-success') !== null) {
  //   Swal.fire({
  //     icon: 'success',
  //     title: 'Success. wait a second',
  //     showConfirmButton: false,
  //     timer: 1500
  //   });
  //   setTimeout(window.location.href="/welcome", 3000);
  // }

  


});

$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})

function enableEdit(id) {
  document.getElementById(id).removeAttribute("disabled");
}

function disableEdit() {
  let basic = document.getElementsByClassName("basic_input");
  for(i=0; i<basic.length; i++) {
      basic[i].disabled = true;
  }
}

function openContent(evt, hideEl) {
  var i, tabcontent;
  tabcontent = document.getElementsByClassName("hide");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none"
  }
  document.getElementById(hideEl).style.display = "block";
}

function search_Univ() { 
  let input = document.getElementById('universitasField').value 
  input=input.toLowerCase(); 
  let x = document.getElementsByClassName('UnivItem'); 
  document.getElementById('UnivBlock').style.display = "block";
  for (i = 0; i < x.length; i++) {  
    if (!x[i].innerHTML.toLowerCase().includes(input)) { 
        x[i].style.display="none"; 
    } 
    else { 
        x[i].style.display="list-item";                  
    } 
  } 
}

function set_univ(val) {
  document.getElementById('universitasField').value = val.innerHTML;
  document.getElementById('UnivBlock').style.display = "none";
}

function search_Major() { 
  let input = document.getElementById('majorField').value 
  input=input.toLowerCase(); 
  let x = document.getElementsByClassName('UnivItem'); 
  document.getElementById('MajorBlock').style.display = "block";
  for (i = 0; i < x.length; i++) {  
    if (!x[i].innerHTML.toLowerCase().includes(input)) { 
        x[i].style.display="none"; 
    }
    else { 
        x[i].style.display="list-item";                  
    } 
  }
}

function set_major(val) {
  document.getElementById('majorField').value = val.innerHTML;
  document.getElementById('MajorBlock').style.display = "none";
}


