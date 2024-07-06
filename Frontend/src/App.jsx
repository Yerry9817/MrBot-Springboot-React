import { useState} from 'react';
import './App.css'
import axios from 'axios';

function App() {

  const [conversation, setConversation] = useState([]);
  const [message, setMessage] = useState("");

  const handleSubmit = async (e)=>{
    e.preventDefault();
    if(message==""){
      return;
    }
    
    try{
      const {data} = await axios.post("http://localhost:8080/api/bot/chat",{message});
      setConversation([...conversation, {user:"user", message}, {user:"bot", message:data}]);
    }catch(err){console.log(err)}
  }
  return (
    <>
      <div className="p-2 absolute h-screen w-full bg-green-300">
        <div className='w-full h-8'>
          <h1 className='rounded-md text-center mb-3 bg-white bg-opacity-65 p-2'>Soy Giru tu asistente virtual, como te puedo ayudar?</h1>
          {conversation?.map((element, index)=>(
            element.user=="user"?(
              <p key={index} className='relative mb-3 left-1/2 bg-purple-300 rounded-md p-1 w-1/2'>{element.message}</p>
            ):(
              <p key={index} className='relative bg-white bg-opacity-65 p-2 rounded-md w-1/2'>{element.message}</p>
            )
          ))}
        </div>
        <div className="sticky top-[93%] left-0 w-full">
            <form className='flex flex-row m-3' action='submit' onSubmit={handleSubmit}>
                <input className='p-2 w-[80%] h-11 mr-1 rounded-lg bg-white bg-opacity-65 focus:outline-none' type="text" onChange={e=>{setMessage(e.target.value)}}/>
                <input className='rounded-xl w-[20%] bg-purple-300' type="submit" value="Send" />
            </form>
        </div>
      </div>
    </>
  )
}

export default App
