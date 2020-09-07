import React, { Component } from 'react';
import comedianService from './services/comedianService.js';
import './App.css';
import ComedianList from './components/ComedianList/ComedianList';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import ComedianHome from './components/ComedianHome/ComedianHome.js';

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
    return (
      <Router>
        <Link to="/">
          Home
        </Link>
        <Link to="/comedianSelected">
          I'm a comedian, laugh asshole
        </Link>
        <Switch>
          <Route path="/">
            <div className="app-comedian-container">
              <ComedianList comedianList={this.state.comedianList} />
            </div>
          </Route>
          <Route path="/comedianSelected">
            <ComedianHome />
          </Route>
        </Switch>
      </Router>
    )
  }
}

export default App;

