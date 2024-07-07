import { useState } from 'react'

const ChatForm = ({handleSubmit}) => {
    const [message, setMessage] = useState('');

    const submit= (e)=>{
        e.preventDefault();
        if(message){
            handleSubmit(message)
        }
    }
  return (
    <form className="flex m-3" onSubmit={submit}>
        <input
            className="p-2 w-full h-11 rounded-lg bg-white bg-opacity-75 focus:outline-none"
            type="text"
            placeholder="Escribe un mensaje..."
            value={message}
            onChange={(e) => setMessage(e.target.value)}
        />
        <button className="rounded-xl bg-purple-300 px-4 ml-2 hover:bg-purple-400" type="submit">
            Send
        </button>
    </form>
  )
}

export default ChatForm
