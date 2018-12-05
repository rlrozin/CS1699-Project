var calculateConvert = document.getElementById("convert-submit-button");

var pounds = document.getElementById("pounds");
var kilograms = document.getElementById("kilograms");

calculateConvert.addEventListener("click", convert);

function convert() {
    var poundsParse = parseFloat(pounds.value) || 0;
    var total = parseInt(poundsParse / 2.205);

    document.getElementById("kiloResult").innerHTML = total;
}
