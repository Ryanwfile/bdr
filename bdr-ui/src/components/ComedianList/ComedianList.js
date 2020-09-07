import React, { Component } from 'react';
import './ComedianList.css';
import Popover from '@material-ui/core/Popover';
import Comedian from '../Comedian/Comedian';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

class ComedianList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            comedianList: this.props.comedianList
        }
    }
   
    render() {
        return (
            <div className="comedianListWrapper">
                {this.props.comedianList.map(comedian => {
                    return <Comedian name={comedian.name} picture={comedian.img_src}></Comedian>
                })}
            </div>

        )
    }
}

export default ComedianList;
