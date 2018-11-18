if (result.children.length === 0) {
    result.style.padding = '0px';
}
let age = document.getElementById("user-age");
let weight = document.getElementById("user-weight");
let activity = document.getElementById("user-activity");

let calculator = document.getElementById("submit-button");
let sum = document.getElementById("result");
let asterix = "*"
let closeAlert = document.getElementById("alertButton");
let height = document.getElementById("height");

//age.addEventListener("input", formula);
//weight.addEventListener("input", formula);

calculator.addEventListener("click", formula);
closeAlert.addEventListener("click", closeAlerts);


let

function formula() {
    handleExceptions()
    let gender = document.getElementById("male-button").checked;
    let ageParse = parseFloat(age.value) || 0;
    let weightParse = parseFloat(weight.value) || 0;
    let heightParse = parseFloat(height.value) || 0;
    let total = (10 * (weightParse * 0.45359237) + 6.25 * heightParse - (5 * ageParse));
    if (gender == true) {
        total = total + 5;
    } else {
        total = total - 161;
    }

    if (activity.value === "sedentary") total *= 1.2;
    else if (activity.value === "light") total *= 1.375;
    else if (activity.value === "moderate") total *= 1.550;
    else if (activity.value === "heavy") total *= 1.725;

    if (sum.length != 0) {
        result.style.padding = '2em 2em';
        showMore();
    }
    sum.innerHTML = Math.round(total) + " calories burned per day ".italics() + asterix.sup();
    show_macros(total, weightParse);
}

function show_macros(calories, bodyweight) {
    let remainingCalories = calories;
    let cuttingProtein = document.getElementsByClassName("cutting-protein");
    let mainProtein = document.getElementsByClassName("main-protein");
    let bulkProtein = document.getElementsByClassName("bulk-protein");

    for (i = 0; i < cuttingProtein.length; i++) {
        cuttingProtein[i].innerHTML = Math.round(bodyweight * 1.1);
    }
    document.getElementById("cuttingHighFat").innerHTML = Math.round(bodyweight * .4);
    remainingCalories -= 300;
    remainingCalories -= (bodyweight * .4 * 9);
    remainingCalories -= Math.round(bodyweight * 1.1 * 4);
    document.getElementById("cuttingLowCarb").innerHTML = Math.round(remainingCalories / 4);

    remainingCalories = calories;
    remainingCalories -= 300;
    remainingCalories -= Math.round(bodyweight * 1.1 * 4);
    document.getElementById("cuttingNormalFat").innerHTML = Math.round(bodyweight * .35);
    remainingCalories -= (bodyweight * .35 * 9);
    document.getElementById("cuttingNormalCarb").innerHTML = Math.round(remainingCalories / 4);

    remainingCalories = calories;
    remainingCalories -= 300;
    remainingCalories -= Math.round(bodyweight * 1.1 * 4);
    document.getElementById("cuttingLowFat").innerHTML = Math.round(bodyweight * .3);
    remainingCalories -= (bodyweight * .3 * 9);
    document.getElementById("cuttingHighCarb").innerHTML = Math.round(remainingCalories / 4);

    for (i = 0; i < mainProtein.length; i++) {
        mainProtein[i].innerHTML = Math.round(bodyweight);
    }
    remainingCalories = calories;
    remainingCalories -= Math.round(bodyweight * 4);
    document.getElementById("mainHighFat").innerHTML = Math.round(bodyweight * .4);
    remainingCalories -= (bodyweight * .4 * 9);
    document.getElementById("mainLowCarb").innerHTML = Math.round(remainingCalories / 4);

    remainingCalories = calories;
    remainingCalories -= Math.round(bodyweight * 4);
    document.getElementById("mainNormalFat").innerHTML = Math.round(bodyweight * .35);
    remainingCalories -= (bodyweight * .35 * 9);
    document.getElementById("mainNormalCarb").innerHTML = Math.round(remainingCalories / 4);

    remainingCalories = calories;
    remainingCalories -= Math.round(bodyweight * 4);
    document.getElementById("mainLowFat").innerHTML = Math.round(bodyweight * .3);
    remainingCalories -= (bodyweight * .3 * 9);
    document.getElementById("mainHighCarb").innerHTML = Math.round(remainingCalories / 4);

    for (i = 0; i < bulkProtein.length; i++) {
        bulkProtein[i].innerHTML = Math.round(bodyweight * .9);
    }
    remainingCalories = calories;
    remainingCalories += 400;
    remainingCalories -= Math.round(bodyweight * .9 * 4);
    document.getElementById("bulkHighFat").innerHTML = Math.round(bodyweight * .4);
    remainingCalories -= (bodyweight * .35 * 9);
    document.getElementById("bulkLowCarb").innerHTML = Math.round(remainingCalories / 4);

    remainingCalories = calories;
    remainingCalories += 400;
    remainingCalories -= Math.round(bodyweight * .9 * 4);
    document.getElementById("bulkNormalFat").innerHTML = Math.round(bodyweight * .35);
    remainingCalories -= (bodyweight * .35 * 9);
    document.getElementById("bulkNormalCarb").innerHTML = Math.round(remainingCalories / 4);

    remainingCalories = calories;
    remainingCalories += 400;
    remainingCalories -= Math.round(bodyweight * .9 * 4);
    document.getElementById("bulkLowFat").innerHTML = Math.round(bodyweight * .3);
    remainingCalories -= (bodyweight * .35 * 9);
    document.getElementById("bulkHighCarb").innerHTML = Math.round(remainingCalories / 4);
}

function showMore() {
    sum.style.display = "inline";
    document.getElementById("equation-source").style.display = "block";
    document.getElementById("eating-plans").style.display = "block";
}

function showLess() {
    sum.style.display = "none";
    document.getElementById("equation-source").style.display = "none";
    document.getElementById("eating-plans").style.display = "none";
}

function handleExceptions() {
    if (age.value == null || age.value == "" || isNaN(age.value)) {
        showLess();
        document.getElementById("missingAlert").style.display = "block";
        document.getElementById("alertText").innerHTML = "You haven't entered a valid age!".italics();
        exit();
    } else {
        document.getElementById("missingAlert").style.display = "none";
    }
    if (weight.value == null || weight.value == "") {
        showLess();
        document.getElementById("missingAlert").style.display = "block";
        document.getElementById("alertText").innerHTML = "You haven't entered a weight!".italics();
        exit();
    } else {
        document.getElementById("missingAlert".style.display = "none");
    }
}

function closeAlerts() {
    document.getElementById("missingAlert").style.display = "none";
}
