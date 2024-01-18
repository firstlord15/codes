import React, { useEffect, useState } from 'react'
import './styles/App.css'
import { usePosts } from './hooks/usePosts'
import PostList from './components/PostList'
import PostForm from './components/PostForm'
import PostFilter from './components/PostFilter'
import MyModal from './components/UI/MyModal/MyModal'
import MyButton from './components/UI/button/MyButton'
import PostService from './API/PostService'
import { useFetching } from './hooks/useFetching'

function App() {
	const [posts, setPosts] = useState([])
	const [filter, setFilter] = useState({ sort: '', query: '' })
	const [modal, setModal] = useState(false)
	const sortedAndSearchedPosts = usePosts(posts, filter.sort, filter.query)

	const [fetchPosts, isPostsLoading, postError] = useFetching(async () => {
		const posts = await PostService.getAll()
		setPosts(posts)
	})

	useEffect(() => {
		fetchPosts()
	}, [])

	const createPost = newPost => {
		setPosts([...posts, newPost])
	}

	const removePost = post => {
		setPosts(posts.filter(p => p.id !== post.id))
	}

	return (
		<div className='App'>
			<button onClick={fetchPosts}>GET POSTS</button>
			<MyButton style={{ marginTop: 30 }} onClick={() => setModal(true)}>
				Создать пользователя
			</MyButton>
			<MyModal visible={modal} setVisible={setModal}>
				<PostForm create={createPost} />
			</MyModal>
			<hr style={{ margin: '15px 0' }} />
			<PostFilter filter={filter} setFilter={setFilter} />

			{postError && <h1>Произошла ошибка ${postError}</h1>}
			{isPostsLoading ? (
				<h1>Идет загрузка...</h1>
			) : (
				<PostList
					remove={removePost}
					posts={sortedAndSearchedPosts}
					title='Посты про JS'
				/>
			)}
		</div>
	)
}

export default App
