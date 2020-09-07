import React, { Component } from 'react';
import comedianService from '../../services/comedianService.js';

class Comedian extends Component {
    render() {
        return (
        <div className="comedian-container">
            <p>{this.props.name}</p>
            <img className="comedian-picture" src={this.props.picture} />
        </div>)

        /** <p>{this.props.name}</p>
                <img className="comedian-picture" src={this.props.picture} /> */
    }
}

export default Comedian;