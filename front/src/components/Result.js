import React, { Fragment } from 'react'
import { connect } from 'react-redux';

const Result = (props) => {
    const orderedNumbers = props.result?.numbersList?.map((value, i = 1) => {
        if((i+1) % props.result?.columns == 0) {
            return (
                <Fragment key={i}>
                    <span className='numero'>{value}</span>
                    <br/>
                </Fragment>
            );
        }
        return (<span className='numero' key={i}>{value} </span>);
    })
    return <div className='titulo'>
        <h3 className='subtitulo'>↓ Numeros generados ↓</h3>
        <div className='contenedorNumeros'>
            {orderedNumbers}
        </div>
    </div>
}

const stateMapToProps = state => {
    return {
        columns: state.random.result?.columns,
        result: state.random.result
    }
}

export default connect(stateMapToProps)(Result)
