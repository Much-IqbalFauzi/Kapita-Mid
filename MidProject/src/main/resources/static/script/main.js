/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function enableEdit(id) {
    document.getElementById(id).removeAttribute("disabled");
}

function disableEdit() {
    let basic = document.getElementsByClassName("basic_input");
    for(i=0; i<basic.length; i++) {
        basic[i].disabled = true;
    }
}