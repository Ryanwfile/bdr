import React, {Component} from 'react';
import './ComedianList.css';
import comedianService from '../../services/comedianService.js';
import Popover from '@material-ui/core/Popover';

class ComedianList extends Component {
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
            <div className="comedianListWrapper">
                <p>{this.props.name}</p>
                {/* <Popover anchorOrigin = {{
                    vertical:'top',
                    horizontal:'left'
                }}
                transformOrigin={{
                    vertical:'top',
                    horizontal:'left'
                }}>Hey, I'm a popover, whats that.</Popover> */}
                <img className="comedian-picture" src={this.props.picture}/>
            </div>
        )
    }
}

export default ComedianList;
