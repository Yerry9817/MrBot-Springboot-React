import axios from "axios";
import ChatContainer from "./components/ChatContainer";
import ChatForm from "./components/ChatForm";
import { useState } from "react";
const ChatBot = () => {
    const [conversation, setConversation] = useState([]);
    const [isLoading, setIsLoading] = useState();

    const addChild = (data)=>{
        setConversation((prevConversation) => [...prevConversation, data]);
    }
    

    const handleSubmit = async (message)=>{
      if(message==""){
        return;
      }
      setIsLoading(true)
      addChild({user:'user',message})
      try{
        const {data} = await axios.post("http://localhost:8080/api/bot/chat",{message});
        setTimeout(()=>{
          setIsLoading(false)
          addChild({user:'bot', message:data})
        },1000)
      }catch(err){
        console.log(err)
      }
    }
  return (
    <div className="h-screen flex flex-col bg-gray-100 md:w-4/5 lg:w-3/5 xl:w-2/5 mx-auto">
        <ChatContainer conversation={conversation} isLoading={isLoading}/>
        <ChatForm handleSubmit={handleSubmit}/>

    </div>
  )
}

export default ChatBot
