import { useRef, useEffect } from 'react';
import { SyncLoader } from 'react-spinners';
import ChatMessage from './ChatMessage';

const ChatContainer = ({conversation, isLoading}) => {
    const chatContainer = useRef(null);
  return (
    <div className="flex-grow overflow-y-auto p-2">
        <div className="flex flex-col" ref={chatContainer}>
            {conversation.map((msg, index) => (
                <ChatMessage key={index} msg={msg} />
            ))}
            {isLoading && (
                <div className="rounded-lg p-2 bg-white self-start">
                <SyncLoader color={'#36D7B7'} loading={true} size={4} />
                </div>
            )} 
        </div>
    </div>
  )
}

export default ChatContainer
