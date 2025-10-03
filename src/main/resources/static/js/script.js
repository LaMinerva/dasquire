const input = document.getElementById("stringa-denaro");
const button = document.getElementById("calcola");
const output = document.getElementById("cript-area-response")

button.addEventListener("clickdashboard", () => {
    let stringaDenaro = input.value;
    let risultato = output.value;

    const arrayOfDenari = stringaDenaro.split(";")

    risultato = stringaDenaro[1]

    document.getElementById("cript-area-response").innerText = `${risultato}`

})