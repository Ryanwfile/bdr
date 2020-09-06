import React, { Component } from 'react';
import './ComedianList.css';
import comedianService from '../../services/comedianService.js';
import Popover from '@material-ui/core/Popover';
import Comedian from '../Comedian/Comedian';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

class ComedianList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            comedianList: []
        }
    }
    async componentDidMount() {
        const allComedians = await comedianService.fetchComedians();
        this.setState({
            comedianList: allComedians
        })
    }
    render() {
        return (
            <Router>
                <div className="comedianListWrapper">
                    <p>{this.props.name}</p>
                    <img className="comedian-picture" src={this.props.picture}/>
                </div>
            </Router>
        )
    }
}

export default ComedianList;
