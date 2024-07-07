// import { useEffect, useRef, useState} from 'react';
// import './App.css'
// import axios from 'axios';
// import {SyncLoader } from 'react-spinners';

// function App() {

//   const [conversation, setConversation] = useState([]);
//   const [message, setMessage] = useState("");
//   const [isLoading, setIsLoading] = useState();
//   const chatContainer = useRef(null);

//   useEffect(()=>{
//     setConversation([{user:"bot", message:'Soy Giru tu asistente virtual, como te puedo ayudar?'}])
//   },[])

//   const addChild = (data)=>{
//     setConversation((prevConversation) => [...prevConversation, data]);
//   }

//   const handleSubmit = async (e)=>{
//     e.preventDefault();
//     if(message==""){
//       return;
//     }
//     console.log(message)
//     addChild({user:'user',message})
//     try{
//       const {data} = await axios.post("http://localhost:8080/api/bot/chat",{message});
//       setConversation([...conversation, {user:"user", message}, {user:"bot", message:data}]);
//       setTimeout(()=>{
//         setIsLoading(false)
//         addChild({user:'bot', message:data})
//       },1000)
//     }catch(err){
//       console.log(err)
//     }finally{
//       console.log(conversation)
//       setMessage('')
//     }
//   }
  
//   return (
//     <>
//       <div className="h-screen flex flex-col bg-gray-100 md:w-4/5 lg:w-3/5 xl:w-2/5 mx-auto">
//         <div className="flex-grow overflow-y-auto p-2">
//           <div className="flex flex-col" ref={chatContainer}>
//             {isLoading && (
//               <div className="rounded-lg p-2 bg-white self-start">
//                 <SyncLoader color={'#36D7B7'} loading={true} size={4} />
//               </div>
//             )} 
//           </div>
//         </div>
//         <form className="flex m-3" onSubmit={handleSubmit}>
//           <input
//             className="p-2 w-full h-11 rounded-lg bg-white bg-opacity-75 focus:outline-none"
//             type="text"
//             placeholder="Escribe un mensaje..."
//             value={message}
//             onChange={(e) => setMessage(e.target.value)}
//           />
//           <button className="rounded-xl bg-purple-300 px-4 ml-2 hover:bg-purple-400" type="submit">
//             Send
//           </button>
//         </form>
//       </div>
//     </>
//   )
// }

// export default App
