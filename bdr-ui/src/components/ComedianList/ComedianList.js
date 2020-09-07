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
        });
    }
    render() {
        return (
            /**<div className="comedian-container">
         {this.state.comedianList.map(comedian => {
         return <ComedianList name={comedian.name} picture={comedian.img_src}></ComedianList>
       })}
       </div> */
            <div className="comedianListWrapper">
                {this.props.comedianList.map(comedian => {
                    return <Comedian name={comedian.name} picture={comedian.img_src}></Comedian>
                })}
            </div>

        )
    }
}

export default ComedianList;
