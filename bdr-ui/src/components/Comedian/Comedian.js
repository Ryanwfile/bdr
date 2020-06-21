import React, {Component} from 'react';
import './Comedian.css';
import comedianService from '../../services/comedianService.js';

class Comedian extends Component {
    constructor(props){
        super(props);
       
    }
   
    componentDidMount(){
        this.comedianList =  comedianService.fetchComedians();
       console.log(this.comedianList.then(resolve => resolve));
        // this.comedianList.map(comedian => {
        //     return comedian;
        // })
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
