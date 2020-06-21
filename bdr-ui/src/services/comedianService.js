const SERVER = "http://localhost:8081/comedians";

const comedianService = {
    async fetchComedians(){
        return await fetch(SERVER, {
            method: 'GET',
            mode: 'cors',
            cache: 'no-cache',
            credentials:'same-origin'
            
        })
    }
}

export default comedianService;