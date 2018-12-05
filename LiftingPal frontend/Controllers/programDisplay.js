var questionnaireButton = document.getElementById("myButton");
questionnaireButton.addEventListener("click", showProgram);

function showProgram() {
    window.location.replace("program.html");
    localStorage.setItem('submitClicked', 'true');
}
