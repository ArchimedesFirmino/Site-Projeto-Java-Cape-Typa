

$(document).ready(runApp)


function runApp() {

    $.get(`http://localhost:8080/artigos/2`)
        .done((data) => {
            console.log(data);
            $(thumbnail).html(`<img src="${data.thumbnail}" alt="">`)
            $(title).html(data.title);
            $(content).html(data.content);
            $.get(`http://localhost:8080/usuarios/${data.author}`)
                .done((author1) => {
                    $(profilePic).html(`<img src="${author1.img}" alt="">`)
                    $(author).html(author1.name);
                    $(description).html(author1.description);
                    $(date).html(author1.birthday);
                    $(email).html(author1.email)
                })
        })

}

