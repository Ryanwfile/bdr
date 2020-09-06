import React, { Component } from 'react';
import logo from './logo.svg';
import Charts from './components/Charts/Charts.js';
import ComedianList from './components/ComedianList/ComedianList.js';
import comedianService from './services/comedianService.js';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

class App extends Component {
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
    console.log(this.state.comedianList);
    return (
      <Router>
        <div className="comedian-container">
          <Link to="/about">
          {this.state.comedianList.map(comedian => {
            return (

              <ComedianList name={comedian.name} picture={comedian.img_src}></ComedianList>

            )
          })}
          </Link>
          <Switch>
            <Route path="/about"><div>Look its a me, your about page</div> </Route>
          </Switch>
        </div>
      </Router>
    )
  }


}

export default App;

