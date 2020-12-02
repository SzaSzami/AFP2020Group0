import React from "react";
import * as actions from '../action/GuestActions';
import ErrorMessageWell from "./ErrorMessageWell";
class GuestRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            name : "E.g. Peter Bonnington",
            age : "E.g. 23"
        };
        this.formOnChange = this.formOnChange.bind(this);
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }

    render() {
        return(
            <div>
                <ErrorMessageWell/>
                    <label htmlFor={"name"} >Name:</label>
                    <input type={"text"} id={"name"} name={"name"} style={{marginLeft: 1 + 'em'}} placeholder={this.state.name} onChange={this.formOnChange}/>
                    <br/>
                    <label htmlFor={"age"}>Age: </label>
                    <input type={"number"} id={"age"} name={"age"} style={{marginLeft: 1.9 + 'em'}} placeholder={this.state.age} onChange={this.formOnChange}/>
                    <br/><br/>
                    <button onClick={()=> actions.recordGuest(this.state)}>Submit</button>
            </div>
        );
    }
}

export default GuestRecordingForm
