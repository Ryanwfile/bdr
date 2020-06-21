import React, {Component} from 'react';
import './Comedian.css';
import comedianService from '../../services/comedianService.js';

class Comedian extends Component {
    constructor(props){
        super(props);    
        this.state = {
            comedianList: []
        }   
    }
   
   async componentDidMount(){       
    const allComedians = await comedianService.fetchComedians();
       this.setState({
         comedianList : allComedians
       })      
    }

    render(){
        return (
            <div className="comedianWrapper">
                <p>{this.props.name}</p>
                <img className="comedian-picture" src={this.props.picture}/>
            </div>
        )
    }
}

export default Comedian;
