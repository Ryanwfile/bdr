import React, { Component } from 'react';
import comedianService from '../../services/comedianService.js';
import './Comedian.css';
class Comedian extends Component {
    render() {
        return (
        <div className="comedian-container">
            <p>{this.props.name}</p>
            <img className="comedian-picture" src={this.props.picture} />
        </div>)
    }
}

export default Comedian;