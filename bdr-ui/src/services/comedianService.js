const SERVER = "http://localhost:8081/comedians";

const comedianService = {

    testWire(){
        console.log("WIRED CORRECTLY");
    },

    // async fetchComedians(){
    //     return await fetch(SERVER, {
    //         method: 'GET',
    //         mode: 'cors',
    //         cache: 'no-cache',
    //         credentials:'same-origin'
            
    //     })
    //     .then(response => response)
    //     .catch(err => console.log("error: ", err));
    // }
    async fetchComedians(){
        return fetch(SERVER)
        .then(response => response.json())
        .then(data => console.log(data));
    }
}

export default comedianService;