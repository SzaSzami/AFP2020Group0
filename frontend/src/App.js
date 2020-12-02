import React from 'react';
import './App.scss';
import GuestRecordingForm from "./component/GuestRecordingForm";
import GuestList from "./component/GuestList";
import * as actions from "./action/GuestActions";



function App() {
  return (
    <div className={["App","container"]}>
        <div className={"row"}>
            <div className={"col-md-3"}></div>
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

export default App;
