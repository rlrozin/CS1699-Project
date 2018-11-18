var calculateMax = document.getElementById("max-submit-button");

var liftedWeight = document.getElementById("user-lifted-weight");
var reps = document.getElementById("user-repetitions");

calculateMax.addEventListener("click", maxFormula);

function maxFormula() {
    var liftedParse = parseFloat(liftedWeight.value) || 0;
    var repsParse = parseFloat(reps.value) || 0;
    var total = (100 * liftedParse) / (101.3 - (2.67123 * repsParse));
    document.getElementById("one-rep-max").innerHTML = total;
}
