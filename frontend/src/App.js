import React from 'react';
import './App.scss';
import GuestRecordingForm from "./component/GuestRecordingForm";
import GuestList from "./component/GuestList";
import * as actions from "./action/GuestActions";



function App() {
  return (
    <div className={["App","container"]}>
        <div className={"row"}>
            <div className={"col-md-3"}>
                <dl style={{marginTop: 3 +'em'}}>
                    <dt onClick={()=> szaunaNav()} style={{marginLeft: 2 +'em'}}>Szauna</dt>
                    <dt onClick={()=> barNav()} style={{marginLeft: 2 +'em'}}>Bar</dt>
                    <dt onClick={()=> billNav()} style={{marginLeft: 2 +'em'}}>Bill</dt>
                </dl>
            </div>
            <form className={"col-md-6"}>
                <h1 style={{marginTop: 1 + 'em'}}>Guest details:</h1><br/>
                <GuestRecordingForm/>
                <GuestList/>
            </form>
            <div className={"col-md-3"}></div>
        </div>
    </div>
  );
}
function szaunaNav() {
    window.location.href = "/szauna/";
}
function barNav() {
    window.location.href = "/bar/";
}
function billNav() {
    window.location.href = "/bill/";
}

export default App;
