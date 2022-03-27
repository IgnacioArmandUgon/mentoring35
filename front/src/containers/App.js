import React, { Component } from 'react'
import From from '../components/From'
import Result from '../components/Result'

class App extends Component { // component stateful
    render() {
        return ( 
            <div className='container'>
                <div className='titulo'>
                    <h1>Numeros random!</h1>
                </div>
                <div className='body'>
                    <div className='main'>
                        <From />
                        <Result />
                    </div>
                </div>
            </div>
        )
    }
}

export default App