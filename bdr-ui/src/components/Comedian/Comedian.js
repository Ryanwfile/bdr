import React, {Component} from 'react';
import './Comedian.css';

class Comedian extends Component {
    constructor(props){
        super(props);
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
