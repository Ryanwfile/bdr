import React, { Component } from 'react';
import logo from './logo.svg';
import Charts from './components/Charts/Charts.js';
import Comedian from './components/Comedian/Comedian.js';
import comedianService from './services/comedianService.js';
import './App.css';
import ComedianList from './components/ComedianList/ComedianList';

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
      <div className="app-comedian-container">
        <ComedianList comedianList={this.state.comedianList}/>
      </div>
    )
  }
}

export default App;

