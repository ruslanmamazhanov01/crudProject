let name = document.getElementById('name')
let email = document.getElementById('email')
const url = 'http://localhost:8080';

let btn = document.getElementById('FormSubmit')


btn.addEventListener('click', (e) => {
    e.preventDefault()
    fetch('http://localhost:8080', {
        method: 'POST',
        body: JSON.stringify({name: name.innerHTML, email: email.innerHTML}),
    })
        .then(response => response.json())
        .then(data => console.log(data))
})
