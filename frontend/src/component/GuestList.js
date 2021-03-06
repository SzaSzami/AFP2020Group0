import React from 'react';
import {default as store} from '../store/GuestStore'
import GuestListItem from "./GuestListItem";

class GuestList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {guests : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({guests : store._guests});
    }

    render() {
        return(
            <div>
                {this.state.guests.map(({name,age}, index)=>{
                    return(
                        <GuestListItem key={index} name={name} age={age}/>
                );
                })}
            </div>
        );
    }
}

export default GuestList;
