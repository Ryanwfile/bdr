import React from 'react';
import logo from './logo.svg';
import Charts from './components/Charts/Charts.js';
import Comedian from './components/Comedian/Comedian.js';
import './App.css';

function App() {
  const nameList = ["Dave Chappelle", "George Carlin", "Richard Pryor", "Jim Gaffigan", "Chris Rock", "Lenny Bruce", "Rodney Dangerfield", "Jerry Seinfeld"];
  return (
    <div className="App">
     
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        {/* <Charts></Charts> */}
        <div className="comedian">
        {nameList.map(name => {
        return <Comedian name={name} picture="https://cdn.britannica.com/96/194196-050-90AA3813/Dave-Chappelle-2006.jpg"></Comedian>
        })}
        </div>
       
       
      
    </div>
  );
}

export default App;
