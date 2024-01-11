import React, { useMemo, useState } from 'react'
import './styles/App.css'
import PostList from './components/PostList'
import PostForm from './components/PostForm'
import MySelect from './components/UI/select/MySelect'
import MyInput from './components/UI/input/MyInput'

function App() {
	const [posts, setPosts] = useState([
		{ id: 1, title: 'зззззз', body: 'яя' },
		{ id: 2, title: 'аааааа', body: 'лвл' },
		{ id: 3, title: 'ыыыыы', body: 'г' },
	])

	const createPost = newPost => {
		setPosts([...posts, newPost])
	}

	const removePost = post => {
		setPosts(posts.filter(p => p.id !== post.id))
	}

	const [selectedSort, setSelectedSort] = useState('')
	const [searchQuery, setSearchQuery] = useState('')

	// поиск
	const sortedPosts = useMemo(() => {
		if (selectedSort) {
			return [...posts].sort((a, b) =>
				a[selectedSort].localeCompare(b[selectedSort])
			)
		}
		return posts
	}, [selectedSort, posts])

	const sortPosts = sort => {
		setSelectedSort(sort)
	}

	const sortedAndSearchedPosts = useMemo(() => {
		return sortedPosts.filter(post =>
			post.title.toLowerCase().includes(searchQuery)
		)
	}, [searchQuery, sortedPosts])

	return (
		<div className='App'>
			<PostForm create={createPost} />
			<hr style={{ margin: '15px 0' }} />
			<div>
				<MyInput
					placeholder='Поиск...'
					onChange={e => setSearchQuery(e.target.value)}
					value={searchQuery}
				/>
			</div>
			<div>
				<MySelect
					value={selectedSort}
					onChange={sortPosts}
					defaultValue='Сортировка'
					option={[
						{ value: 'title', name: 'По названию' },
						{ value: 'body', name: 'По описанию' },
					]}
				/>
			</div>
			{posts.length !== 0 ? (
				<PostList
					remove={removePost}
					posts={sortedAndSearchedPosts}
					title='Посты про JS'
				/>
			) : (
				<h1 style={{ textAlign: 'center' }}>Посты не найдены</h1>
			)}
		</div>
	)
}

export default App
