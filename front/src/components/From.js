import React, { useState } from 'react'
import { connect } from 'react-redux';
import { fetchRandom } from '../actions';

const From = (props) => {// component stateless
    const [state, setState] = useState({columns: 0, amount: 0, initialNumber: 0, finalNumber: 0});
    const onSubmit = (e) => {
        e.preventDefault();
        props.dispatch(fetchRandom(state));
    };
    return <div className='contenedorForm'>
        <form autocomplete="off" className='form' onSubmit={onSubmit}>
            <h3 className='subtitulo'>Introduce los parametros</h3>
            <ol>
                <li>
                <label className='formLabel' htmlFor='amount'>Cantidad de numeros: </label>
            <input className='formInput' name='amount' id='amount' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
                </li>
                <li>
                <label className='formLabel' htmlFor='initialNumber'>Menor numero posible:</label>
            <input className='formInput' name='initialNumber' id='initialNumber' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
                </li>
                <li>
                <label className='formLabel' htmlFor='finalNumber'>Mayor numero posible:</label>
            <input className='formInput' name='finalNumber' id='finalNumber' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
                </li>
            </ol>
            
            <button className="boton" type="submit" disabled={props.loading}>Get numbers</button>
        </form>
    </div>
}


const stateMapToProps = state => {
    return {
        loading: state.view.loading
    }
}


export default connect(stateMapToProps)(From)
